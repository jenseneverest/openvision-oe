DESCRIPTION = "dumpait"

PRIORITY = "required"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.GPLv3;md5=5ed852a46d22220a8b07a68e564d84c7"

DEPENDS = "libdvbsi++"

SRC_URI = "git://github.com/OpenVuPlus/dumpait.git"
S = "${WORKDIR}/git"
DESTDIR = "enigma2/python/Plugins/Extensions/HbbTV"

inherit gitpkgv autotools-brokensep pkgconfig

SRCREV = "1adfdd7dadb760a8ff2107dce60e2f99ca74fa5d"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

RREPLACES_${PN} = "vuplus-opera-dumpait"
RCONFLICTS_${PN} = "vuplus-opera-dumpait"

do_install() {
	install -d ${D}${libdir}/${DESTDIR}
	install -m 0755 ${S}/src/dumpait ${D}${libdir}/${DESTDIR}
}

FILES_${PN} = "${libdir}/${DESTDIR}/dumpait"
FILES_${PN}-dbg += "${libdir}/${DESTDIR}/.debug/dumpait"
