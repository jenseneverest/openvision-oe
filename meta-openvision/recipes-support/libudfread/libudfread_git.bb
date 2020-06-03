SUMMARY  = "UDF reader"
SECTION = "misc"
HOMEPAGE = "http://videolan.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit gitpkgv autotools-brokensep pkgconfig

SRC_URI = "git://github.com/OpenVisionE2/libudfread.git"

PV = "1.0.0+git${SRCPV}"
PKGV = "1.0.0+git${GITPKGV}"

S="${WORKDIR}/git"
