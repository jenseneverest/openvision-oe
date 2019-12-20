SUMMARY = "Open implementation of the AACS specification"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4b54a1fd55a448865a0b32d41598759d"

DEPENDS = "libgcrypt"

inherit autotools lib_package pkgconfig

PV = "0.9.0+git${SRCPV}"

SRC_URI = "git://github.com/OpenVisionE2/libaacs.git"

S = "${WORKDIR}/git"
