require conf/license/openvision-gplv2.inc
require softcam.inc
require oscam-config.inc

DESCRIPTION = "OScam ${PV} Open Source Softcam"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
SRC_URI = "git://github.com/OpenVisionE2/oscam.git;protocol=https"

B = "${S}"
CAMNAME = "oscam"
CAMSTART = "${bindir}/oscam --wait 0 --config-dir ${sysconfdir}/tuxbox/config/oscam --daemon --pidfile /tmp/oscam.pid --restart 2 --utf8"
CAMSTOP = "kill \`cat /tmp/oscam.pid\` 2> /dev/null"

SRC_URI += "\
	file://oscam.conf \
	file://oscam.server \
	file://oscam.srvid \
	file://oscam.user \
	file://oscam.provid"

CONFFILES = "${sysconfdir}/tuxbox/config/oscam/oscam.conf ${sysconfdir}/tuxbox/config/oscam/oscam.server ${sysconfdir}/tuxbox/config/oscam/oscam.srvid ${sysconfdir}/tuxbox/config/oscam/oscam.user ${sysconfdir}/tuxbox/config/oscam/oscam.provid"

FILES_${PN} = "${bindir}/oscam ${sysconfdir}/tuxbox/config/oscam/* ${sysconfdir}/init.d/softcam.oscam"

do_install() {
	install -d ${D}${sysconfdir}/tuxbox/config/oscam
	install -m 0644 ${WORKDIR}/oscam.* ${D}${sysconfdir}/tuxbox/config/oscam/
	install -d ${D}${bindir}
	install -m 0755 ${B}/oscam ${D}${bindir}/oscam
}
