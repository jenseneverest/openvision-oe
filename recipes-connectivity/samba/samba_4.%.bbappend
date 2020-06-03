FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit upx_compress

RDEPENDS_${PN} += "kernel-module-cifs"
