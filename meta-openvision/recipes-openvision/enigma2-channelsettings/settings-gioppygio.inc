SUMMARY = "GioppyGio enigma2 settings"
LICENSE = "CLOSED"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/GioppyGio-settings.git"

S = "${WORKDIR}/git"

inherit allarch gitpkgv

FILES_${PN} = "${sysconfdir}/enigma2/"

do_install () {
	install -d ${D}${sysconfdir}/enigma2
	cp -r ${S}/${SETTINGS_FILENAME}/* ${D}${sysconfdir}/enigma2
	rm -rf ${D}${sysconfdir}/enigma2/satellites.xml*
}
