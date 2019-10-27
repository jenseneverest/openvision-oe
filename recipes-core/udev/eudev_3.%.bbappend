FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_sh4 += " \
    file://add-sh4.patch \
    file://udev-builtin-input_id.patch \
"
