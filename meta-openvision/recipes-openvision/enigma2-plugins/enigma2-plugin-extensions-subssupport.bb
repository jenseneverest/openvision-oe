SUMMARY = "Collection of enigma2 subtitles plugins"
HOMEPAGE = "https://github.com/mx3L/subssupport"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

RDEPENDS_${PN} = "${PYTHONNAMEONLY}-requests ${PYTHONNAMEONLY}-xmlrpc ${PYTHONNAMEONLY}-compression ${PYTHONNAMEONLY}-codecs ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "", "python-zlib", d)} python-difflib unrar"

inherit gitpkgv autotools-brokensep gettext rm_python_pyc compile_python_pyo no_python_src

SRC_URI = "git://github.com/mx3L/subssupport;protocol=git;branch=master"

S = "${WORKDIR}/git"

PV = "1.5.8+git${SRCPV}"
PKGV = "1.5.8+git${GITPKGV}"

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/SubsSupport \
${localstatedir}/lib/subssupport"

do_install_append() {
    install -d ${D}${localstatedir}/lib/subssupport
}

