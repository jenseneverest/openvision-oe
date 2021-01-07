DESCRIPTION = "redistributes streams from DVB on a network using multicast or HTTP unicast"
AUTHOR = "Brice Dubost"
HOMEPAGE = "http://mumudvb.braice.net/"
SECTION = "console/multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2"

SRC_URI = "https://github.com/braice/MuMuDVB/archive/${PV}.tar.gz"

SRC_URI[md5sum] = "fd26e5c77bd33c3fbe9d9e6f07b7d98f"
SRC_URI[sha256sum] = "beb61cb8d3c61ad4d8c7389374599bdf7d9ccff134728bf2833b710f64584e13"

S = "${WORKDIR}/MuMuDVB-${PV}"

inherit autotools
