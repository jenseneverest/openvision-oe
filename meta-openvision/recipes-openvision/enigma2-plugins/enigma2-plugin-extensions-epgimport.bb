SUMMARY = "Imports xmltv files into the EPG cache of enigma2"
MAINTAINER = "oe-alliance"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../etc/epgimport/readme.txt;startline=1;endline=4;md5=c162054328d930d453543efef81be1d8"

inherit gitpkgv ${PYTHONNAMEONLY}native gettext distutils-openplugins

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/oe-alliance/XMLTV-Import.git;protocol=git"

S = "${WORKDIR}/git/src"

DEPENDS = "${PYTHONNAMEONLY}"
RDEPENDS_${PN} = "${PYTHONNAMEONLY}-compression ${PYTHONNAMEONLY}-shell ${PYTHONNAMEONLY}-lzma ${PYTHONNAMEONLY}-pkgutil"
RRECOMMENDS_${PN} = "${PN}-rytec"
PACKAGES = "${PN}-dbg ${PN}"

RREPLACES_${PN} = "enigma2-plugin-extensions-xmltvimport"
RCONFLICTS_${PN} = "enigma2-plugin-extensions-xmltvimport"

PLUGIN = "EPGImport"

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/ /etc"
FILES_${PN}-dbg = "${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/.debug /usr/src/debug"
FILES_${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/*.py"
