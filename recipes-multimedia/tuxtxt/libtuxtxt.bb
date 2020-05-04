SUMMARY = "tuxbox libtuxtxt"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "libpng freetype zlib"

inherit gitpkgv autotools pkgconfig

SRC_URI = "git://github.com/OpenVisionE2/tuxtxt.git;protocol=git"

S = "${WORKDIR}/git/libtuxtxt"

EXTRA_OECONF = "${@bb.utils.contains("MACHINE_FEATURES", "tuxtxtclearscreen", "--with-tuxtxtclearscreen" , "", d)}"

PV = "2.0.1+git${SRCPV}"
PKGV = "2.0.1+git${GITPKGV}"

FILES_${PN} = "${libdir}/libtuxtxt.so.*"
FILES_${PN}-dev += "${libdir}/libtuxtxt.la ${libdir}/pkgconfig/tuxbox-tuxtxt.pc"

