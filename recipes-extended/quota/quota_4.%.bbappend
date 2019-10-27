FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "\
	${@bb.utils.contains("MACHINE_FEATURES", "oldkernel", "file://fix_old_header.patch", "", d)} \
	"

SRC_URI_append_sh4 += "file://fix_old_header.patch"
