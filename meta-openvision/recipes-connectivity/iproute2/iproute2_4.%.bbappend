FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "\
	${@bb.utils.contains("MACHINE_FEATURES", "oldkernel", "file://iproute2_oldkernel.patch", "", d)} \
	"

inherit upx_compress
