DESCRIPTION = "Handle your EPG on enigma2 using opentv and xmltv"
HOMEPAGE = "https://github.com/LraiZer/RadiotimesXmltvEmulator"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc178bcd425090939a8b634d1d6a9594"

inherit gitpkgv rm_python_pyc compile_python_pyo no_python_src

PV = "1.0.0+gitr${SRCPV}"
PKGV = "1.0.0+gitr${GITPKGV}"

ALLOW_EMPTY_${PN} = "1"


SRC_URI = "git://github.com/LraiZer/RadiotimesXmltvEmulator.git;branch=gui-plugin;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
    echo ${PV} > ${S}/VERSION
    oe_runmake SWIG="swig"
}

do_install() {
    oe_runmake 'D=${D}' install-plugin
}

pkg_postrm_${PN}() {
rm -fr ${libdir}/enigma2/python/Plugins/SystemPlugins/RadiotimesXmltvEmulator > /dev/null 2>&1
}

FILES_${PN}_append = " ${prefix}"
