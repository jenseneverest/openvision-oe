FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_sh4 += "\
	file://hotplug-e2-helper.patch \
	"
