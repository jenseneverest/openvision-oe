require conf/license/openvision-gplv2.inc
require softcam.inc
inherit cmake gitpkgv upx_compress

DESCRIPTION = "ncam ${PV} Open Source Softcam"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
SRC_URI = "git://github.com/OpenVisionE2/NCam.git"

DEPENDS = "libusb openssl"

S = "${WORKDIR}/git"
B = "${S}"
CAMNAME = "ncam"
CAMSTART = "${bindir}/ncam --wait 0 --config-dir ${sysconfdir}/tuxbox/config/ncam --daemon --pidfile /tmp/ncam.pid --restart 2 --utf8"
CAMSTOP = "kill \`cat /tmp/ncam.pid\` 2> /dev/null"

SRC_URI += " \
	file://ncam.conf \
	file://ncam.server \
	file://ncam.srvid \
	file://ncam.user \
	file://ncam.provid"

CONFFILES = "${sysconfdir}/tuxbox/config/ncam/ncam.conf ${sysconfdir}/tuxbox/config/ncam/ncam.server ${sysconfdir}/tuxbox/config/ncam/ncam.srvid ${sysconfdir}/tuxbox/config/ncam/ncam.user ${sysconfdir}/tuxbox/config/ncam/ncam.provid"

FILES_${PN} = "${bindir}/ncam ${sysconfdir}/tuxbox/config/ncam/* ${sysconfdir}/init.d/softcam.ncam"

EXTRA_OECMAKE += "\
	-DOSCAM_SYSTEM_NAME=Tuxbox \
	-DWEBIF=1 \
	-DWEBIF_LIVELOG=1 \
	-DWEBIF_JQUERY=1 \
	-DWITH_STAPI=0 \
	-DHAVE_LIBUSB=1 \
	-DSTATIC_LIBUSB=0 \
	-DWITH_SSL=1 \
	-DIPV6SUPPORT=1 \
	-DCLOCKFIX=0 \
	-DHAVE_PCSC=1 \
	-DCARDREADER_SMARGO=1 \
	-DCARDREADER_PCSC=1 \
	-DCW_CYCLE_CHECK=1 \
	-DCS_CACHEEX=1 \
	-DMODULE_CONSTCW=1 \
	"

do_install() {
	install -d ${D}${sysconfdir}/tuxbox/config/ncam
	install -m 0644 ${WORKDIR}/ncam.* ${D}${sysconfdir}/tuxbox/config/ncam/
	install -d ${D}${bindir}
	install -m 0755 ${B}/ncam ${D}${bindir}
}
