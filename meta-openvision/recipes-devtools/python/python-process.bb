SUMMARY = "Python process list module"
SECTION = "devel/python"
PRIORITY = "optional"
SRCNAME = "process"

require conf/license/license-gplv2.inc

inherit ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "distutils3-base", "distutils-base", d)}

PKGV = "1.0"

SRC_URI = "file://process.py"

S = "${WORKDIR}"

PACKAGES = "${PN} ${PN}-src"

FILES_${PN} = "${PYTHON_SITEPACKAGES_DIR}/process.pyo"
FILES_${PN}-src = "${PYTHON_SITEPACKAGES_DIR}/process.py"
RDEPENDS_{PN}-src = "${PN}"

do_compile() {
    ${PYTHONEXACTVERSION} -O -m compileall ${WORKDIR}/process.py
}

do_install() {
	install -d ${D}${PYTHON_SITEPACKAGES_DIR}
	if [ "${PYTHONEXACTVERSION}" = "python3" ]; then
		install -m 644 ${S}/process.py ${D}${PYTHON_SITEPACKAGES_DIR}/
	else
		install -m 644 ${S}/process.py ${D}${PYTHON_SITEPACKAGES_DIR}/
		install -m 644 ${S}/process.pyo ${D}${PYTHON_SITEPACKAGES_DIR}/
	fi
}
