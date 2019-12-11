FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "\
    file://tools-Add-support-for-rtk_h5-type.patch \
    ${@bb.utils.contains("MACHINE_FEATURES", "oldkernel", "file://old_kernel.patch", "", d)} \
"

SRC_URI_remove ="file://0001-tools-Add-support-for-rtk_h5-type.patch"
