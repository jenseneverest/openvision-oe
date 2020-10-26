DESCRIPTION = "KeyAdder for Add BISS, PowerVU, Irdeto and Tandberg keys to current service."
LICENSE = "GPLv3"
AUTHOR = "RAED"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/OpenVisionE2/KeyAdder.git;protocol=git"

inherit gitpkgv distutils-openplugins gettext

S = "${WORKDIR}/git"

PV = "2.5+git${SRCPV}"
PKGV = "2.5+git${GITPKGV}"
