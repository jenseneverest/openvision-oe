LICENSE = "CLOSED"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/haroo/HansSettings.git"

S = "${WORKDIR}/git"

inherit gitpkgv allarch

FILES_${PN} = "${sysconfdir}/enigma2/"

do_install () {
	install -d ${D}${sysconfdir}/enigma2
	cp -r ${S}/${SETTINGS_FILENAME}/* ${D}${sysconfdir}/enigma2
	rm -rf ${D}${sysconfdir}/enigma2/satellites.xml*
}
