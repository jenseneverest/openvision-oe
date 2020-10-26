DESCRIPTION = "BHweather plugin by Meo modified by RAED"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/OpenVisionE2/BHweather;protocol=git"

inherit gitpkgv distutils-openplugins

S = "${WORKDIR}/git"

PV = "0.6+git${SRCPV}"
PKGV = "0.6+git${GITPKGV}"
