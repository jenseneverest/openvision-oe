MODULE = "OscamStatus"
DESCRIPTION = "shows status of your oscam server"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://remove-duplicate-server-name.patch"

require conf/license/license-gplv2.inc
require openplugins-replace-vision.inc
require openplugins-distutils.inc
