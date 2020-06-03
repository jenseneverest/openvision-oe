FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "\
	${@bb.utils.contains("MACHINE_FEATURES", "oldkernel", "file://define-RTNL_FAMILY_MAX.patch", "", d)} \
	"
