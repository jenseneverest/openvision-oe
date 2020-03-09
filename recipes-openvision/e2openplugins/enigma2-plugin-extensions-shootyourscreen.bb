MODULE = "ShootYourScreen"
DESCRIPTION = "create screenshots with remote control of your STB"
RDEPENDS_${PN} = "aio-grab"

inherit gitpkgv

PV = "0.2+git${SRCPV}"
PKGV = "0.2+git${GITPKGV}"

require conf/license/license-gplv2.inc
require openplugins-distutils.inc
