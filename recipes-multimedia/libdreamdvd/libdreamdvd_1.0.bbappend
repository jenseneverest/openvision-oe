FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_sh4 += "file://libdreamdvd-1.0-support_sh4.patch;patch=1"

CFLAGS_append_sh4 += " -std=gnu11"
