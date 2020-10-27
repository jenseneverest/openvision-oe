DESCRIPTION = "ovlock"
SECTION = "base"
PRIORITY = "required"
require conf/license/license-gplv2.inc

inherit rm_python_pyc compile_python_pyo no_python_src

SRC_URI = "file://ov.py"

FILES_${PN} = "${prefix}"

S = "${WORKDIR}"

PACKAGES = "${PN}"

do_install() {
	install -d ${D}${libdir}/${PYTHONPATHVERSION}
	install -m 0644 ${WORKDIR}/ov.${PYTHONEXTENSION} ${D}${libdir}/${PYTHONPATHVERSION}
}
