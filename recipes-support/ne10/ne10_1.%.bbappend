FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_cube += "file://declare-variables-outside-for-loop.patch"
SRC_URI_append_su980 += "file://declare-variables-outside-for-loop.patch"
