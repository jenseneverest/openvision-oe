SUMMARY  = "UDF reader"
SECTION = "misc"
HOMEPAGE = "http://videolan.org"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM="file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit gitpkgv autotools-brokensep pkgconfig

PV = "1.0.0+git${SRCPV}"
PKGV = "1.0.0+git${GITPKGV}"

SRC_URI = "git://code.videolan.org/videolan/libudfread;protocol=https"

S="${WORKDIR}/git"
