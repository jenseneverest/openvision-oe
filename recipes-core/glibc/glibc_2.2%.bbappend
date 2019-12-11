FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

SRC_URI_append_sh4 += "\
    file://glibc-fix-with-old-kernel.patch \
    file://sh4-trap.patch \
"

INSANE_SKIP_${PN} += "textrel"
