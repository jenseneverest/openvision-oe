SUMMARY = "Kraven HD skin for Enigma2"
MAINTAINER = "Team Kraven"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "python-imaging python-subprocess python-requests python-lxml enigma2-plugin-systemplugins-mphelp"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/KravenHD/KravenHD.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}/* ${sysconfdir}/*"

require skin-data.inc
require skin-python.inc

do_postrm_append() {
#!/bin/sh
rm -rf ${datadir}/enigma2/KravenHD
rm -rf ${libdir}/enigma2/python/Plugins/Extensions/KravenHD
rm -rf ${libdir}/enigma2/python/Components/Converter/KravenHD*
rm -rf ${libdir}/enigma2/python/Components/Renderer/KravenHD*
echo "                                                          "
echo "              ...Skin successful removed.                 "
echo "                                                          "
}
