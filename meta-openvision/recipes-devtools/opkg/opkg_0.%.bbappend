FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_dm800 += "file://revert-commit-7a8c2f6.patch"
