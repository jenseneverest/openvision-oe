MAINTAINER = "OE-A"
LICENSE = "CLOSED"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/oe-alliance/oe-alliance-settings.git"

S = "${WORKDIR}/git"

inherit allarch gitpkgv

FILES_${PN} = "${sysconfdir}/enigma2/"

do_install () {
	install -d ${D}${sysconfdir}/enigma2
	cp -r ${S}/${SETTINGS_FILENAME}/* ${D}${sysconfdir}/enigma2
	if [ -e ${D}${sysconfdir}/enigma2/satellites.xml ]; then
		rm -f ${D}${sysconfdir}/enigma2/satellites.xml
	fi
}
