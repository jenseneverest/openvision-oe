DESCRIPTION = "Rytec's XMLTV sources and channels for the EPGImporter"

require conf/license/openvision-gplv2.inc

inherit allarch

PV = "20200504"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "file://rytec.sources.xml"

S = "${WORKDIR}"

RREPLACES_${PN} = "enigma2-plugin-extensions-xmltvimport-rytec"
RCONFLICTS_${PN} = "enigma2-plugin-extensions-xmltvimport-rytec"

DEPENDS = "enigma2-plugin-extensions-epgimport"

PACKAGES = "${PN}"

FILES_${PN} = "${sysconfdir}/epgimport"

do_install() {
	install -d ${D}${sysconfdir}/epgimport
	install -m 644 ${S}/rytec.sources.xml ${D}${sysconfdir}/epgimport/
}
