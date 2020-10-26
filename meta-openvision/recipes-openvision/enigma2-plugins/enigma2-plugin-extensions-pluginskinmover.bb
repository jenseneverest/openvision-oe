DESCRIPTION = "PluginSkinMover"
LICENSE = "GPLv3"
AUTHOR = "mfaraj and schomi"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/OpenVisionE2/PluginSkinMover.git;protocol=git"

inherit gitpkgv distutils-openplugins gettext

S = "${WORKDIR}/git"

PV = "0.6+git${SRCPV}"
PKGV = "0.6+git${GITPKGV}"
