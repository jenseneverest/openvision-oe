DESCRIPTION = "OverlayHD skin and management plugin for Enigma2 PVRs by IanSav"
SECTION = "skins"
PRIORITY = "optional"
MAINTAINER = "IanSav <IS.OzPVR@gmail.com>"
LICENSE = "GPLv2"
HOMEPAGE = "https://github.com/IanSav"
SOURCE = "https://github.com/IanSav/OverlayHD"

inherit gitpkgv allarch

require skin-data.inc
require skin-python.inc

PV = "1.83-git${SRCPV}"
PKGV = "1.83-git${GITPKGV}"

SRC_URI = "git://github.com/IanSav/OverlayHD.git;protocol=git"

S = "${WORKDIR}/git"

do_package_qa[noexec] = "1"

FILES_${PN} = "${prefix}"

RDEPENDS_${PN} = "enigma2-plugin-extensions-overlayhd"
