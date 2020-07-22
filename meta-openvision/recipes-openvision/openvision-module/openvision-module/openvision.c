#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/slab.h>
#include <linux/string.h>
#include <linux/timer.h>
#include <linux/major.h>
#include <linux/fs.h>
#include <linux/err.h>
#include <linux/ioctl.h>
#include <linux/init.h>
#include <linux/proc_fs.h>
#include <linux/version.h>
#if LINUX_VERSION_CODE > KERNEL_VERSION(3,10,1)
#include <linux/seq_file.h>
#endif

static struct proc_dir_entry *proc_openvision;

DEFINE_MUTEX(openvision_table_mutex);

#if LINUX_VERSION_CODE < KERNEL_VERSION(3,10,1)
static int openvision_read_proc (char *page, char **start, off_t off, int count, int *eof, void *data_unused)
{
        int len;
        off_t   begin = 0;

        mutex_lock(&openvision_table_mutex);

        len = sprintf(page, "https://openvision.tech\n");
        mutex_unlock(&openvision_table_mutex);
        if (off >= len+begin)
                return 0;
        *start = page + (off-begin);
        return ((count < begin+len-off) ? count : begin+len-off);
}

static int __init init_openvision(void)
{

		if ((proc_openvision = create_proc_entry( "stb/info/openvision", 0666, NULL )))
                proc_openvision->read_proc = openvision_read_proc;
        return 0;
}

static void __exit cleanup_openvision(void)
{
        remove_proc_entry( "stb/info/openvision", NULL);
}
#else
static int proc_openvision_show(struct seq_file *seq, void *v)
{
        seq_printf(seq, "https://openvision.tech\n");
        return 0;
}

int proc_openvision_open(struct inode *inode, struct file *file)
{ 
	return single_open(file, proc_openvision_show, PDE_DATA(inode));
}

static const struct file_operations proc_fops = {
	.owner		= THIS_MODULE,
	.open		= proc_openvision_open,
	.read		= seq_read,
	.llseek		= seq_lseek,
	.release	= single_release,
};

static int __init init_openvision(void)
{
	printk(KERN_INFO "Open Vision @VISIONVERSION@-@VISIONREVISION@\n");
	printk(KERN_INFO "STB=@MACHINE@\n");
	printk(KERN_INFO "Brand/Meta=@BOX_BRAND@\n");
	printk(KERN_INFO "Platform=@STB_PLATFORM@\n");
	printk(KERN_INFO "creator=Open Vision developers\n");
	printk(KERN_INFO "url=https://openvision.tech\n");
	printk(KERN_INFO "catalog=https://github.com/OpenVisionE2\n");
	printk(KERN_INFO "visionlanguage=@VISIONLANGUAGE@\n");
	printk(KERN_INFO "oe=@BUILD_VERSION@\n");
	printk(KERN_INFO "python=@PREFERRED_VERSION_python@\n");
	printk(KERN_INFO "multilib=@HAVE_MULTILIB@\n");
	printk(KERN_INFO "architecture=@DEFAULTTUNE@\n");
	printk(KERN_INFO "socfamily=@SOC_FAMILY@\n");
	printk(KERN_INFO "compiledby=@DEVELOPER_NAME@\n");
	proc_openvision = proc_create_data( "stb/info/openvision", 0666, NULL, &proc_fops, NULL );
        return 0;
}

static void __exit cleanup_openvision(void)
{
        remove_proc_entry( "stb/info/openvision", NULL);
}
#endif
module_init(init_openvision);
module_exit(cleanup_openvision);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Open Vision developers");
MODULE_DESCRIPTION("Open Vision information");
