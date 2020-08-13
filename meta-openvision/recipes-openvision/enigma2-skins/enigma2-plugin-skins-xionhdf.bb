SUMMARY = "XION skin for HDF Images"
MAINTAINER = "Team Kraven"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "python-requests"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/KravenHD/XionHDF.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}"

require skin-data.inc
require skin-python.inc

do_postrm_append() {
#!/bin/sh
rm -rf ${datadir}/enigma2/XionHDF
rm -rf ${libdir}/enigma2/python/Plugins/Extensions/XionHDF
rm -rf ${libdir}/enigma2/python/Components/Converter/XionHDF*
rm -rf ${libdir}/enigma2/python/Components/Renderer/XionHDF*
echo "                                                          "
echo "              ...Skin successful removed.                 "
echo "                                                          "
}
