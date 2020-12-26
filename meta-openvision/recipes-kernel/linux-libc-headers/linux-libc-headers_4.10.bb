require linux-libc-headers.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://fsxattr.patch"
