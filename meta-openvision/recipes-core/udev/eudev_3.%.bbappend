FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_dm800 = " \
	file://add-dm800.patch \
	file://udev-builtin-input_id.patch \
	"
