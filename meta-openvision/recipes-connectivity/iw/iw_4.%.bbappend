FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "\
	${@bb.utils.contains("MACHINE_FEATURES", "oldkernel", "file://legacy_kernel.patch", "", d)} \
	"
