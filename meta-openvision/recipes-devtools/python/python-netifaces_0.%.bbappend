FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_sh4 = " file://define-RTNL_FAMILY_MAX.patch"

include python-package-split.inc
