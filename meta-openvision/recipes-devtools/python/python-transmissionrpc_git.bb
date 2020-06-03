DESCRIPTION = "Transmission RPC is a python module that can communicate with the bittorrent client Transmission through json-rpc"
HOMEPAGE = "http://bitbucket.org/blueluna/transmissionrpc/wiki/Home"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
RDEPENDS_${PN} = "python-simplejson"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/transmissionrpc.git"

S = "${WORKDIR}/git"

inherit setuptools gitpkgv
