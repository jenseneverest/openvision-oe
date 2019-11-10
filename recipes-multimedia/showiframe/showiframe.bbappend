FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_sh4 += "file://showiframe-sh4.patch"

INSANE_SKIP_${PN} += "ldflags"

PACKAGE_ARCH = "${MACHINE_ARCH}"
