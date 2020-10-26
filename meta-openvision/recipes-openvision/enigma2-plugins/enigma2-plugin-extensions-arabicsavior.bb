DESCRIPTION = "ArabicSavior plugin by mfaraj57"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/OpenVisionE2/ArabicSavior;protocol=git"

inherit gitpkgv distutils-openplugins gettext

S = "${WORKDIR}/git"

PV = "1.2+git${SRCPV}"
PKGV = "1.2+git${GITPKGV}"
