require conf/license/openvision-gplv2.inc
require softcam.inc
require oscam-config.inc

DESCRIPTION = "ncam ${PV} Open Source Softcam"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
SRC_URI = "git://github.com/OpenVisionE2/NCam.git"

B = "${S}"
CAMNAME = "ncam"
CAMSTART = "${bindir}/ncam --wait 0 --config-dir ${sysconfdir}/tuxbox/config/ncam --daemon --pidfile /tmp/ncam.pid --restart 2 --utf8"
CAMSTOP = "kill \`cat /tmp/ncam.pid\` 2> /dev/null"

SRC_URI += "\
	file://ncam.conf \
	file://ncam.server \
	file://ncam.srvid \
	file://ncam.user \
	file://ncam.provid \
	file://CCcam.cfg"

CONFFILES = "${sysconfdir}/tuxbox/config/ncam/ncam.conf ${sysconfdir}/tuxbox/config/ncam/ncam.server ${sysconfdir}/tuxbox/config/ncam/ncam.srvid ${sysconfdir}/tuxbox/config/ncam/ncam.user ${sysconfdir}/tuxbox/config/ncam/ncam.provid ${sysconfdir}/tuxbox/config/ncam/CCcam.cfg"

FILES_${PN} = "${bindir}/ncam ${sysconfdir}/tuxbox/config/ncam/* ${sysconfdir}/init.d/softcam.ncam"

do_install() {
	install -d ${D}${sysconfdir}/tuxbox/config/ncam
	install -m 0644 ${WORKDIR}/ncam.* ${D}${sysconfdir}/tuxbox/config/ncam/
	install -d ${D}${bindir}
	install -m 0755 ${B}/ncam ${D}${bindir}
}
