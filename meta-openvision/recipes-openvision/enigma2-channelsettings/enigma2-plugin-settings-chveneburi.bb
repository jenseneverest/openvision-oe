DESCRIPTION = "Enigma2 motor setting by chveneburi (30W-100.5E)"
MAINTAINER = "dreamosat team"

require conf/license/openvision-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/audi06/chveneburi_Settings.git"

S = "${WORKDIR}/git/E2_Sat_Settings_Motor_100.5E-30W"

FILES_${PN} = "${sysconfdir}/enigma2/"

do_install () {
	install -d ${D}${sysconfdir}/enigma2
	cp -r ${S}/* ${D}${sysconfdir}/enigma2
	if [ -e ${D}${sysconfdir}/enigma2/satellites.xml ]; then
		rm -f ${D}${sysconfdir}/enigma2/satellites.xml*
	fi
}
