SUMMARY = "Small command line utility used to perform frequency scans for DVB and ATSC transmissions"
DESCRIPTION = "Wscan is a dvb channel scanner that doesn't require an initial frequency table"
HOMEPAGE = "http://wirbel.htpc-forum.de/w_scan/index2.html"
MAINTAINER = "wirbel <w_scan@gmx-topmail.de>"
COMPATIBLE_MACHINE = "^(dm800|cube|su980)$"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "http://cdn-fastly.deb.debian.org/debian/pool/main/w/w-scan/w-scan_${PV}.orig.tar.bz2"

SRC_URI[md5sum] = "dfc14a4707321e068a594d6899398df8"
SRC_URI[sha256sum] = "422414e9f13bfb574aace014c6f4dd2175f7eeb08ba9d5e3187cf02fae1522bf"

S = "${WORKDIR}/w_scan-${PV}"

inherit autotools

FILES_${PN} += "${datadir}"
