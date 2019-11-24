DESCRIPTION = "QuadPiP plugin for VU+ UHD receivers"

require conf/license/openvision-gplv2.inc

inherit gitpkgv
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

S = "${WORKDIR}/git"
SRC_URI = "git://github.com/OpenPLi/enigma2-plugin-systemplugins-quadpip.git;protocol=http"

inherit distutils-openplugins
