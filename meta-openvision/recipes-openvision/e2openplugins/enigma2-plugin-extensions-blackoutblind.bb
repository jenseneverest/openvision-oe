MODULE = "Blackoutblind"
DESCRIPTION = "Hide white dotted lines (VBI) on top of the screen"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

require conf/license/license-gplv2.inc
require openplugins-replace-vision.inc
require openplugins-distutils.inc
