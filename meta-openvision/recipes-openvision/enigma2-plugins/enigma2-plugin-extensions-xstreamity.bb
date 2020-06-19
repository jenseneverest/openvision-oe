DESCRIPTION = "IPTV Xtream Codes playlists player by KiddaC"
HOMEPAGE = "https://www.linuxsat-support.com"
MAINTAINER = "kiddac"
PRIORITY = "optional"
require conf/license/license-gplv2.inc

RDEPENDS_${PN} = "python-argparse python-image python-imaging python-multiprocessing python-requests"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

inherit gitpkgv rm_python_pyc compile_python_pyo no_python_src rm_language_po

SRC_URI = "git://github.com/kiddac/XStreamity.git \
        file://get-rid-of-dreamos-checks.patch \
"

S = "${WORKDIR}/git"

FILES_${PN} = " ${libdir}/enigma2/python/Components/Converter/* \
                ${libdir}/enigma2/python/Components/Renderer/* \
                ${libdir}/enigma2/python/Plugins/Extensions/XStreamity/*"

do_install() {
    install -d ${D}${libdir}/enigma2/python/Components/Converter
    install -d ${D}${libdir}/enigma2/python/Components/Renderer
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/XStreamity
    cp -rf ${S}/XStreamity/usr/lib/enigma2/python/Components/Converter/* ${D}${libdir}/enigma2/python/Components/Converter/
    cp -rf ${S}/XStreamity/usr/lib/enigma2/python/Components/Renderer/* ${D}${libdir}/enigma2/python/Components/Renderer/
    cp -rf ${S}/XStreamity/usr/lib/enigma2/python/Plugins/Extensions/XStreamity/* ${D}${libdir}/enigma2/python/Plugins/Extensions/XStreamity/
}

pkg_preinst_${PN}() {
#!/bin/sh
if [ -f "${sysconfdir}/enigma2/X-Streamity/playlists.json" ]
    then
    rm -f ${sysconfdir}/enigma2/X-Streamity/playlists.json > /dev/null 2>&1
fi

if [ -f "${sysconfdir}/enigma2/xstreamity/playlists.json" ]
    then
    rm -f ${sysconfdir}/enigma2/xstreamity/playlists.json > /dev/null 2>&1
fi
}

pkg_postrm_${PN} () {
#!/bin/sh
rm -rf ${libdir}/enigma2/python/Plugins/Extensions/XStreamity > /dev/null 2>&1
rm -f ${libdir}/enigma2/python/Components/Renderer/xRunningText.py* > /dev/null 2>&1
rm -f ${libdir}/enigma2/python/Components/Converter/xServiceInfo.py* > /dev/null 2>&1
rm -rf ${sysconfdir}/enigma2/X-Streamity
rm -rf ${sysconfdir}/enigma2/xstreamity
}
