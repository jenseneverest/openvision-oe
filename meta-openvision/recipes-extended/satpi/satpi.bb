SUMMARY = "SAT>IP server for linux, suitable for running on an Raspberry Pi, VU+, BeagleBone or any other linux box."
LICENSE = "GPLv2+ & LGPLv2.1+"
HOMEPAGE = "https://github.com/Barracuda09/SATPI/wiki"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

inherit autotools-brokensep

DEPENDS = "libdvbcsa openssl"

RDEPENDS_${PN} = "libdvbcsa openssl"

SRC_URI = "git://github.com/Barracuda09/SATPI.git;protocol=http \
    file://makefile.patch \
"

PV = "git${SRCPV}"

S = "${WORKDIR}/git"
BUILD = "${WORKDIR}/git"

EXTRA_OECONF = "ENIGMA=yes"

CXXFLAGS = " -std=c++11"

do_install () {
    install -d -m 0755 ${D}${bindir}
    install -m 0755 ${S}/satpi ${D}${bindir}/
}
