SUMMARY = "tuxbox tuxtxt for framebuffer"
DESCRIPTION = "tuxbox tuxtxt for enigma2"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "freetype libtuxtxt"

inherit gitpkgv autotools pkgconfig

SRC_URI = "git://github.com/OpenVisionE2/tuxtxt.git;protocol=git"

S = "${WORKDIR}/git/tuxtxt"

PV = "2.0.1+git${SRCPV}"
PKGV = "2.0.1+git${GITPKGV}"

EXTRA_OECONF = "--with-configdir=${sysconfdir} \
	${@bb.utils.contains("MACHINE_FEATURES", "textlcd", "--with-textlcd" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "nogamma", "--with-nogamma" , "", d)} \
	"

do_install_append() {
	# remove unused .pyc files
	find ${D}${libdir}/enigma2/python/ -name '*.pyc' -exec rm {} \;
}

PACKAGES = "${PN}-src ${PN}-dbg ${PN}-dev ${PN}"
FILES_${PN}-src = "/usr/src ${libdir}/enigma2/python/Plugins/Extensions/Tuxtxt/*.py"
FILES_${PN} = "${libdir}/libtuxtxt32bpp.so.* ${datadir}/fonts ${libdir}/enigma2/python/Plugins/Extensions/Tuxtxt/*.pyo ${sysconfdir}/tuxtxt"
CONFFILES_${PN} = "${sysconfdir}/tuxtxt/tuxtxt2.conf"
