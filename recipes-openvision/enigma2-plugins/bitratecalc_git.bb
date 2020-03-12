DESCRIPTION = "Library that implements bitrate calculations from enigma2"
LICENSE = "CC-BY-NC-ND-4.0"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/meta-openpli/licenses/CC-BY-NC-ND-4.0;md5=8009795292660aa9c8da059e5b1581c1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "enigma2"

inherit gitpkgv autotools pythonnative pkgconfig

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/bitratecalc.git;protocol=http"

CXXFLAGS_append_sh4 += " -std=c++11 "
CXXFLAGS_append_cube += " -std=c++11 "
CXXFLAGS_append_su980 += " -std=c++11 "

S = "${WORKDIR}/git"

FILES_${PN} = "${libdir}/bitratecalc.so"
