MODULE = "ChangeRootPassword"
DESCRIPTION = "Set/Change your box password"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

require conf/license/license-gplv2.inc
require openplugins-distutils.inc
