DESCRIPTION = "MerlinInfo by DarkVolli modified by RAED"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

RDEPENDS_${PN} = "smartmontools libcrypto-compat"

SRC_URI = "git://github.com/OpenVisionE2/merlininfo.git;protocol=git"

inherit gitpkgv distutils-openplugins gettext

S = "${WORKDIR}/git"

PV = "2.1+git${SRCPV}"
PKGV = "2.1+git${GITPKGV}"
